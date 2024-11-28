import React, { useEffect, useState } from 'react';
import {
  YMaps, Map, Clusterer, Placemark,
} from '@pbe/react-yandex-maps';
import api from '../../utils/Api.js';
import Header from '../Header/Header.jsx';
import clients from '../../utils/constant.js';

function App() {
  function getAddress(address) {
    let refAddress = address.replaceAll(/\s/g, '+');
    refAddress = refAddress.replaceAll(/,/g, '');
    const coordinates = [];
    api.getCoordinates(refAddress)
      .then((res) => {
        coordinates.push(res.response.GeoObjectCollection.featureMember[0].GeoObject.Point.pos.slice(-9));
        coordinates.push(res.response.GeoObjectCollection.featureMember[0].GeoObject.Point.pos.slice(0, 9));
      })
      .catch((err) => console.log(err));
    return coordinates;
  }

  return (
    <div className="app">
      <Header />
      <div className="app__container">
        <div className="app__content">
          <table className="app__table">
            <thead>
              <tr>
                <th className="app__table-header">
                  Список клиентов
                </th>
              </tr>
            </thead>
            <tbody>
              {clients.map((client) => (
                <tr className="app__table-row" key={client.client}>
                  <td className="app__table-id">
                    {client.client}
                  </td>
                  <td className="app__table-gender">
                    {client.gender}
                  </td>
                  <td className="app__table-age">
                    {client.age}
                  </td>
                  <td className="app__table-address">
                    {client.address.address}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="app__map-content">
          <YMaps>
            <Map className="app__map" defaultState={{ center: [51.676729, 39.244346], zoom: 11 }}>
              <Clusterer
                options={{
                  preset: 'islands#darkOrangeClusterIcons',
                  groupByCoordinates: false,
                }}
              >
                {
                  clients.map((client) => (
                    <Placemark
                      key={client.client}
                      geometry={getAddress(client.address.address)}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#f58220',
                        }
                      }
                    />
                  ))
                }
              </Clusterer>
            </Map>
          </YMaps>
        </div>
      </div>
    </div>
  );
}

export default App;

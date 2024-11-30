import React from 'react';
import {
  YMaps, Map, Placemark,
} from '@pbe/react-yandex-maps';

function ClientsMap({ clients }) {
  return (
    <div className="map">
      <YMaps>
        <Map className="map__content" defaultState={{ center: [51.676729, 39.204346], zoom: 11 }}>
          {
              clients.map((client) => {
                if (client.age === '10-19') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#89a5dd',
                        }
                      }
                    />
                  );
                } if (client.age === '20-29') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#7793cb',
                        }
                      }
                    />
                  );
                } if (client.age === '30-39') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#6481ba',
                        }
                      }
                    />
                  );
                } if (client.age === '40-49') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#526fa8',
                        }
                      }
                    />
                  );
                } if (client.age === '50-59') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#405d96',
                        }
                      }
                    />
                  );
                } if (client.age === '60-69') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#2e4b84',
                        }
                      }
                    />
                  );
                } if (client.age === '70-79') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#1b3973',
                        }
                      }
                    />
                  );
                } if (client.age === '80-89') {
                  return (
                    <Placemark
                      key={client.client}
                      geometry={[Number(client.address.coordinates.slice(0, 9)), Number(client.address.coordinates.slice(-9))]}
                      options={
                        {
                          preset: 'islands#circleDotIcon',
                          iconColor: '#092761',
                        }
                      }
                    />
                  );
                }
              })
            }
        </Map>
      </YMaps>
    </div>
  );
}

export default ClientsMap;

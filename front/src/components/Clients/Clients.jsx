import React, { useEffect, useState } from 'react';
import ClientsMap from '../Map/ClientsMap.jsx';
import api from '../../utils/Api.js';

function Clients() {
  const [filterAge, setFilterAge] = useState([]);
  const [clients, setClients] = useState([]);
  const [filteredClients, setFilteredClients] = useState([]);

  function handleClientsFilter(age) {
    if (age.length === 0) {
      setFilteredClients(clients);
    } else {
      const acc = [];
      for (let i = 0; i <= age.length - 1; i += 1) {
        clients.forEach((client) => {
          if (client.age === age[i]) {
            acc.push(client);
          }
        });
      }
      setFilteredClients(acc);
    }
  }

  function handleAgeFilter(age) {
    if (filterAge.includes(age)) {
      setFilterAge((state) => state.filter((el) => el !== age));
      handleClientsFilter(filterAge.filter((el) => el !== age));
    } else {
      setFilterAge((state) => [...state, age]);
      handleClientsFilter([...filterAge, age]);
    }
  }

  useEffect(() => {
    api.getClients()
      .then((res) => {
        setClients(res);
        setFilteredClients(res);
      });
  }, []);

  return (
    <div className="clients">
      <div className="clients__content">
        <table className="clients__table">
          <thead>
            <tr>
              <th className="clients__table-header">
                <h2 className="clients__table-title">
                  Список клиентов
                </h2>
                <div className="clients__table-buttons">
                  <button
                    type="button"
                    className={filterAge.includes('10-19') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('10-19')}
                  >
                    10+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('20-29') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('20-29')}
                  >
                    20+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('30-39') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('30-39')}
                  >
                    30+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('40-49') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('40-49')}
                  >
                    40+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('50-59') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('50-59')}
                  >
                    50+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('60-69') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('60-69')}
                  >
                    60+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('70-79') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('70-79')}
                  >
                    70+
                  </button>
                  <button
                    type="button"
                    className={filterAge.includes('80-89') ? 'clients__table-button clients__table-button_active' : 'clients__table-button'}
                    onClick={() => handleAgeFilter('80-89')}
                  >
                    80+
                  </button>
                </div>
              </th>
            </tr>
          </thead>
          <tbody>
            {filteredClients.length > 0 ? filteredClients.map((client) => (
              <tr className="clients__table-row" key={client.client}>
                <td className="clients__table-id">
                  {client.client}
                </td>
                <td className="clients__table-gender">
                  {client.gender}
                </td>
                <td className="clients__table-age">
                  {client.age}
                </td>
                <td className="clients__table-address">
                  {client.address.address}
                </td>
              </tr>
            )) : (
              <tr className="clients__table-row">
                <td className="clients__table-notfound">
                  По данным критериям клиенты не найдены
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
      <ClientsMap clients={filteredClients} />
    </div>
  );
}

export default Clients;

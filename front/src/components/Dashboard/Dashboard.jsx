import React, { useEffect, useState } from 'react';
import api from '../../utils/Api.js';

function Dashboard() {
  const [stats, setStats] = useState([]);
  const [activeFilter, setActiveFilter] = useState('');

  useEffect(() => {
    if (activeFilter === '') {
      api.getAllStats()
        .then((res) => {
          setStats(res.slice(0, 10));
        });
    } else if (activeFilter === 'М' || activeFilter === 'Ж') {
      api.getFilteredGenderStats(activeFilter)
        .then((res) => setStats(res.slice(0, 10)));
    } else {
      api.getFilteredStats(activeFilter)
        .then((res) => setStats(res.slice(0, 10)));
    }
  }, [activeFilter]);

  useEffect(() => {
    api.getAllStats()
      .then((res) => {
        setStats(res.slice(0, 10));
      });
  }, []);

  return (
    <div className="dashboard">
      <div className="dashboard__filters">
        <button
          className={activeFilter === 'М' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('М')}
        >
          М
        </button>
        <button
          className={activeFilter === 'Ж' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('Ж')}
        >
          Ж
        </button>
        <button
          className={activeFilter === '10-19' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('10-19')}
        >
          10-19
        </button>
        <button
          className={activeFilter === '20-29' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('20-29')}
        >
          20-29
        </button>
        <button
          className={activeFilter === '30-39' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('30-39')}
        >
          30-39
        </button>
        <button
          className={activeFilter === '40-49' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('40-49')}
        >
          40-49
        </button>
        <button
          className={activeFilter === '50-59' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('50-59')}
        >
          50-59
        </button>
        <button
          className={activeFilter === '60-69' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('60-69')}
        >
          60-69
        </button>
        <button
          className={activeFilter === '70-79' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('70-79')}
        >
          70-79
        </button>
        <button
          className={activeFilter === '80-89' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('80-89')}
        >
          80-89
        </button>
        <button
          className={activeFilter === '' ? 'dashboard__button dashboard__button_active' : 'dashboard__button'}
          onClick={() => setActiveFilter('')}
        >
          Без фильтра
        </button>
      </div>
      {
        stats.map((stat) => (
          <div key={stat.id} className="dashboard__item">
            <div className="dashboard__item-id">
              {stat.client.client}
            </div>
            <div className="dashboard__item-address">
              {stat.client.address.address}
            </div>
            <div className="dashboard__item-gender">
              {stat.client.gender}
            </div>
            <div className="dashboard__item-age">
              {stat.client.age}
            </div>
            <div className="dashboard__item-duration">
              {stat.duration}
            </div>
            <div className="dashboard__item-channel">
              {stat.channelId}
            </div>
            <div className="dashboard__item-category">
              {stat.category}
            </div>
          </div>
        ))
      }
    </div>
  );
}

export default Dashboard;

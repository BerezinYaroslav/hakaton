import React, { useEffect, useState } from 'react';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import Charts from '../Charts/Charts.jsx';
import api from '../../utils/Api.js';
import analiz1 from '../../assets/images/analiz_1.jpg';
import analiz2 from '../../assets/images/analiz_2.jpg';

function Stats() {
  ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
  );

  const [devices, setDevices] = useState([]);
  const [channels, setChannels] = useState([]);
  const [categories, setCategories] = useState([]);
  const [subcategories, setSubcategories] = useState([]);

  useEffect(() => {
    api.getPopularDevices()
      .then((res) => setDevices(res));
    api.getPopularChannels()
      .then((res) => setChannels(res));
    api.getPopularCategories()
      .then((res) => setCategories(res));
    api.getPopularSubcategories()
      .then((res) => setSubcategories(res));
  }, []);

  return (
    <div className="stats">
      <h1 className="stats__title">
        Статистика
      </h1>
      {
        devices.length > 0 && (
          <Charts
            labels={[devices[0].device, devices[1].device, devices[2].device, devices[3].device, devices[4].device]}
            data={[devices[0].count, devices[1].count, devices[2].count, devices[3].count, devices[4].count]}
            backgroundColor="#0b82ae"
            title="Самые популярные устройства"
            caption="Кол-во устройств"
          />
        )
      }
      {
        channels.length > 0 && (
          <Charts
            labels={[channels[0].channel_id, channels[1].channel_id, channels[2].channel_id, channels[3].channel_id, channels[4].channel_id]}
            data={[channels[0].sum, channels[1].sum, channels[2].sum, channels[3].sum, channels[4].sum]}
            backgroundColor="#0b82ae"
            title="Самые популярные каналы"
            caption="Время просмотра (мин)"
          />
        )
      }
      {
        categories.length > 0 && (
          <Charts
            labels={[categories[0].category, categories[1].category, categories[2].category, categories[3].category, categories[4].category]}
            data={[categories[0].sum, categories[1].sum, categories[2].sum, categories[3].sum, categories[4].sum]}
            backgroundColor="#0b82ae"
            title="Самые популярные категории"
            caption="Время просмотра (мин)"
          />
        )
      }
      {
        subcategories.length > 0 && (
          <Charts
            labels={[subcategories[0].subcategory, subcategories[1].subcategory, subcategories[2].subcategory, subcategories[3].subcategory, subcategories[4].subcategory]}
            data={[subcategories[0].sum, subcategories[1].sum, subcategories[2].sum, subcategories[3].sum, subcategories[4].sum]}
            backgroundColor="#0b82ae"
            title="Самые популярные подкатегории"
            caption="Время просмотра (мин)"
          />
        )
      }
      <h1 className="stats__title">
        Кластерный анализ
      </h1>
      <img src={analiz1} alt="кластерный анализ" className="stast__chart" />
      <img src={analiz2} alt="кластерный анализ" className="stast__chart" />
    </div>
  );
}

export default Stats;

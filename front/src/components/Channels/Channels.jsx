import React, { useEffect, useState } from 'react';
import {
  Chart as ChartJS,
  RadialLinearScale,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  PointElement,
  LineElement,
  Filler,
  Tooltip,
  Legend,
} from 'chart.js';
import { Radar, Bar } from 'react-chartjs-2';
import api from '../../utils/Api.js';

function Channels() {
  ChartJS.register(
    RadialLinearScale,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    PointElement,
    LineElement,
    Filler,
    Tooltip,
    Legend,
  );

  const [elkaData, setElkaData] = useState([]);
  const [channelData, setChannelData] = useState({});

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'bottom',
      },
    },
  };

  const radarData = {
    labels: ['Досуг', 'Фильм', 'Инфо', 'Остальное', 'Познавательное', 'Для взрослых', 'Сериал', 'Детям', 'Спорт'],
    datasets: [
      {
        label: '10-19',
        data: [elkaData?.[0]?.['Досуг'] || 0, elkaData?.[0]?.['Фильм'] || 0, elkaData?.[0]?.['Инфо'] || 0, elkaData?.[0]?.['Остальное'] || 0, elkaData?.[0]?.['Познавательное'] || 0, elkaData?.[0]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[0]?.['Детям'] || 0, elkaData?.[0]?.['Спорт'] || 0],
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1,
      },
      {
        label: '20-29',
        data: [elkaData?.[1]?.['Досуг'] || 0, elkaData?.[1]?.['Фильм'] || 0, elkaData?.[1]?.['Инфо'] || 0, elkaData?.[1]?.['Остальное'] || 0, elkaData?.[1]?.['Познавательное'] || 0, elkaData?.[1]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[1]?.['Детям'] || 0, elkaData?.[1]?.['Спорт'] || 0],
        backgroundColor: 'rgba(221,99,255,0.2)',
        borderColor: 'rgb(245,99,255)',
        borderWidth: 1,
      },
      {
        label: '30-39',
        data: [elkaData?.[2]?.['Досуг'] || 0, elkaData?.[2]?.['Фильм'] || 0, elkaData?.[2]?.['Инфо'] || 0, elkaData?.[2]?.['Остальное'] || 0, elkaData?.[2]?.['Познавательное'] || 0, elkaData?.[2]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[2]?.['Детям'] || 0, elkaData?.[2]?.['Спорт'] || 0],
        backgroundColor: 'rgba(99,120,255,0.2)',
        borderColor: 'rgb(143,99,255)',
        borderWidth: 1,
      },
      {
        label: '40-49',
        data: [elkaData?.[3]?.['Досуг'] || 0, elkaData?.[3]?.['Фильм'] || 0, elkaData?.[3]?.['Инфо'] || 0, elkaData?.[3]?.['Остальное'] || 0, elkaData?.[3]?.['Познавательное'] || 0, elkaData?.[3]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[3]?.['Детям'] || 0, elkaData?.[3]?.['Спорт'] || 0],
        backgroundColor: 'rgba(99,255,242,0.2)',
        borderColor: 'rgb(99,250,255)',
        borderWidth: 1,
      },
      {
        label: '50-59',
        data: [elkaData?.[4]?.['Досуг'] || 0, elkaData?.[4]?.['Фильм'] || 0, elkaData?.[4]?.['Инфо'] || 0, elkaData?.[4]?.['Остальное'] || 0, elkaData?.[4]?.['Познавательное'] || 0, elkaData?.[4]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[4]?.['Детям'] || 0, elkaData?.[4]?.['Спорт'] || 0],
        backgroundColor: 'rgba(99,255,143,0.2)',
        borderColor: 'rgb(99,255,125)',
        borderWidth: 1,
      },
      {
        label: '60-69',
        data: [elkaData?.[5]?.['Досуг'] || 0, elkaData?.[5]?.['Фильм'] || 0, elkaData?.[5]?.['Инфо'] || 0, elkaData?.[5]?.['Остальное'] || 0, elkaData?.[5]?.['Познавательное'] || 0, elkaData?.[5]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[5]?.['Детям'] || 0, elkaData?.[5]?.['Спорт'] || 0],
        backgroundColor: 'rgba(211,255,99,0.2)',
        borderColor: 'rgb(203,255,99)',
        borderWidth: 1,
      },
      {
        label: '70-79',
        data: [elkaData?.[6]?.['Досуг'] || 0, elkaData?.[6]?.['Фильм'] || 0, elkaData?.[6]?.['Инфо'] || 0, elkaData?.[6]?.['Остальное'] || 0, elkaData?.[6]?.['Познавательное'] || 0, elkaData?.[6]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[6]?.['Детям'] || 0, elkaData?.[6]?.['Спорт'] || 0],
        backgroundColor: 'rgba(255,229,99,0.2)',
        borderColor: 'rgb(255,200,99)',
        borderWidth: 1,
      }, {
        label: '80-89',
        data: [elkaData?.[7]?.['Досуг'] || 0, elkaData?.[7]?.['Фильм'] || 0, elkaData?.[7]?.['Инфо'] || 0, elkaData?.[7]?.['Остальное'] || 0, elkaData?.[7]?.['Познавательное'] || 0, elkaData?.[7]?.['Для взрослых'] || 0, elkaData?.[0]?.['Сериал'] || 0, elkaData?.[7]?.['Детям'] || 0, elkaData?.[7]?.['Спорт'] || 0],
        backgroundColor: 'rgba(99,161,255,0.2)',
        borderColor: 'rgb(99,120,255)',
        borderWidth: 1,
      },
    ],
  };

  const barData = {
    labels: ['Спорт+ HD', 'КХЛ HD', 'Спорт 1 HD', 'Матч Премьер', 'Матч! Футбол', 'TV Бизнес Спорт', 'TV Бизнес', 'Viasat', 'Дождь', 'Unicast', 'Базовый Блок 1', 'Базовый Блок 3', 'Базовый Блок 4', 'pack129', 'pack123', 'Для взрослых', 'Настрой кино', 'Настрой кино Акция', 'viju+', 'Путешествия HD', 'Общедоступный'],
    datasets: [
      {
        label: 'Среднее время просмотра (мин)',
        data: [Number(channelData['Спорт+ HD']?.avg_time), Number(channelData['КХЛ HD']?.avg_time), Number(channelData['Спорт 1 HD']?.avg_time), Number(channelData['Матч Премьер']?.avg_time), Number(channelData['Матч! Футбол']?.avg_time), Number(channelData['TV Бизнес Спорт']?.avg_time), Number(channelData['TV Бизнес']?.avg_time), Number(channelData.Viasat?.avg_time), Number(channelData['Дождь']?.avg_time), Number(channelData.Unicast?.avg_time), Number(channelData['Базовый Блок 1']?.avg_time), Number(channelData['Базовый Блок 3']?.avg_time), Number(channelData['Базовый Блок 4']?.avg_time), Number(channelData.pack129?.avg_time), Number(channelData.pack123?.avg_time), Number(channelData['Для взрослых']?.avg_time), Number(channelData['Настрой кино']?.avg_time), Number(channelData['Настрой кино Акция']?.avg_time), Number(channelData['viju+']?.avg_time), Number(channelData['Путешествия HD']?.avg_time), Number(channelData['Общедоступный']?.avg_time)],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
        ],
        borderWidth: 1,
      },
    ],
  };

  useEffect(() => {
    const acc = [];

    api.getElkaStats('10-19')
      .then((res) => acc[0] = res);
    api.getElkaStats('20-29')
      .then((res) => acc[1] = res);
    api.getElkaStats('30-39')
      .then((res) => acc[2] = res);
    api.getElkaStats('40-49')
      .then((res) => acc[3] = res);
    api.getElkaStats('50-59')
      .then((res) => acc[4] = res);
    api.getElkaStats('60-69')
      .then((res) => acc[5] = res);
    api.getElkaStats('70-79')
      .then((res) => acc[6] = res);
    api.getElkaStats('80-89')
      .then((res) => {
        acc[7] = res;
        setElkaData(acc);
      });
  }, []);

  useEffect(() => {
    const acc = {};

    api.getChannelStats('Unicast')
      .then((res) => acc.Unicast = res);
    api.getChannelStats('pack129')
      .then((res) => acc.pack129 = res);
    api.getChannelStats('Viasat')
      .then((res) => acc.Viasat = res);
    api.getChannelStats('Матч Премьер')
      .then((res) => acc['Матч Премьер'] = res);
    api.getChannelStats('Настрой кино Акция')
      .then((res) => acc['Настрой кино Акция'] = res);
    api.getChannelStats('Путешествия HD')
      .then((res) => acc['Путешествия HD'] = res);
    api.getChannelStats('TV Бизнес')
      .then((res) => acc['TV Бизнес'] = res);
    api.getChannelStats('Спорт+ HD')
      .then((res) => acc['Спорт+ HD'] = res);
    api.getChannelStats('viju+')
      .then((res) => acc['viju+'] = res);
    api.getChannelStats('Спорт 1 HD')
      .then((res) => acc['Спорт 1 HD'] = res);
    api.getChannelStats('Базовый Блок 4')
      .then((res) => acc['Базовый Блок 4'] = res);
    api.getChannelStats('Базовый Блок 3')
      .then((res) => acc['Базовый Блок 3'] = res);
    api.getChannelStats('Общедоступный')
      .then((res) => acc['Общедоступный'] = res);
    api.getChannelStats('Матч! Футбол')
      .then((res) => acc['Матч! Футбол'] = res);
    api.getChannelStats('Дождь')
      .then((res) => acc['Дождь'] = res);
    api.getChannelStats('Для взрослых')
      .then((res) => acc['Для взрослых'] = res);
    api.getChannelStats('pack123')
      .then((res) => acc.pack123 = res);
    api.getChannelStats('Базовый Блок 1')
      .then((res) => acc['Базовый Блок 1'] = res);
    api.getChannelStats('TV Бизнес Спорт')
      .then((res) => acc['TV Бизнес Спорт'] = res);
    api.getChannelStats('КХЛ HD')
      .then((res) => acc['КХЛ HD'] = res);
    api.getChannelStats('Настрой кино')
      .then((res) => {
        acc['Настрой кино'] = res;
        setChannelData(acc);
      });
  }, []);

  return (
    <div className="channels">
      <h1 className="channels__title">
        Анализ каналов
      </h1>

      <div className="channels__radar">
        <h2 className="channels__subtitle">
          Среднее время просмотра каждой категории для каждой группы возрастов
        </h2>
        {
          elkaData.length > 0 && (
            <Radar data={radarData} options={options} />
          )
        }
      </div>

      <button onClick={() => console.log(channelData)}>
        sqsa
      </button>

      <div className="channels__radar">
        <h2 className="channels__subtitle">
          Среднее время просмотра каждого пакета каналов
        </h2>
        <Bar data={barData} options={options} />
      </div>
    </div>
  );
}

export default Channels;

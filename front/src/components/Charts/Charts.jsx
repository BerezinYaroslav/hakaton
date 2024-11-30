import React from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  ArcElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';

function Charts({
  labels, data, backgroundColor, title, caption,
}) {
  ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    ArcElement,
    Title,
    Tooltip,
    Legend,
  );

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'bottom',
      },
    },
  };

  const chartBarData = {
    labels,
    datasets: [{
      label: caption,
      data,
      backgroundColor,
      borderWidth: 1,
    }],
  };

  const chartPieData = {
    labels,
    datasets: [{
      label: caption,
      data,
      backgroundColor: [
        'rgba(255, 99, 132, 0.7)',
        'rgba(54, 162, 235, 0.7)',
        'rgba(255, 206, 86, 0.7)',
        'rgba(75, 192, 192, 0.7)',
        'rgba(153, 102, 255, 0.7)',
        'rgba(255, 159, 64, 0.7)',
      ],
      borderColor: [
        'rgb(246,30,76)',
        'rgb(31,153,236)',
        'rgb(246,185,34)',
        'rgb(34,230,230)',
        'rgb(105,39,236)',
        'rgb(237,134,31)',
      ],
      borderWidth: 1,
    }],
  };

  return (
    <div className="charts">
      <h2 className="charts__subtitle">
        {title}
      </h2>

      <div className="charts__field">
        <div className="charts__chart">
          <Bar options={options} data={chartBarData} />
        </div>
        <div className="charts__chart">
          <Pie options={options} data={chartPieData} />
        </div>
      </div>
    </div>
  );
}

export default Charts;

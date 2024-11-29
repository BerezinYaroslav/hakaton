import axios from 'axios';

class Api {
  constructor({ baseUrl }) {
    this._baseUrl = baseUrl;
  }

  _checkResponse(response) {
    if (response.status === 200) {
      return response.data;
    }

    return Promise.reject(`Ошибка: ${response.status}`);
  }

  getCoordinates(address) {
    return axios.get(`https://geocode-maps.yandex.ru/1.x/?apikey=4f649acd-f8a6-4d9e-b485-4955e974c616&geocode=${address}&format=json`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res))
      .catch((err) => console.log(err));
  }

  getClients() {
    return axios.get(`${this._baseUrl}/clients`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }
}

const api = new Api({
  baseUrl: 'http://localhost:8080',
});

export default api;

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

  getClients() {
    return axios.get(`${this._baseUrl}/clients`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getPopularDevices() {
    return axios.get(`${this._baseUrl}/stats/devices`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getPopularChannels() {
    return axios.get(`${this._baseUrl}/stats/channels`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getPopularCategories() {
    return axios.get(`${this._baseUrl}/stats/categories`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getPopularSubcategories() {
    return axios.get(`${this._baseUrl}/stats/subcategories`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getAllStats() {
    return axios.get(`${this._baseUrl}/stats`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getFilteredGenderStats(filter) {
    return axios.get(`${this._baseUrl}/stats/gender/${filter}`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getFilteredStats(filter) {
    return axios.get(`${this._baseUrl}/stats/age/${filter}`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getElkaStats(age) {
    return axios.get(`${this._baseUrl}/stats/elka/${age}`, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => this._checkResponse(res));
  }

  getChannelStats(channel) {
    return axios.get(`${this._baseUrl}/stats/channels/avgTime/${channel}`, {
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

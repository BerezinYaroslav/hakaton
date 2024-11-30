import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from '../Header/Header.jsx';
import Stats from '../Stats/Stats.jsx';
import Clients from '../Clients/Clients.jsx';
import Channels from '../Channels/Channels.jsx';
import Dashboard from '../Dashboard/Dashboard.jsx';

function App() {
  return (
    <div className="app">
      <Header />
      <div className="app__container">
        <Routes>
          <Route path="/" element={<Stats />} />
          <Route path="/clients" element={<Clients />} />
          <Route path="/channels" element={<Channels />} />
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;

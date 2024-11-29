import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../../assets/images/freedom.svg';

function Header() {
  return (
    <header className="header">
      <img src={logo} className="header__logo" alt="лого" />
      <nav className="header__links">
        <Link to="/" className="header__link">
          Каналы
        </Link>
        <Link to="/" className="header__link">
          Клиенты
        </Link>
        <Link to="/" className="header__link header__link_active">
          Карта
        </Link>
      </nav>
    </header>
  );
}

export default Header;

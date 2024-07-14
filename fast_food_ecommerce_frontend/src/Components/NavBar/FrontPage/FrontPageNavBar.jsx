import React, { useState, useContext } from 'react';
import logo from '../../../Asserts/KFC.png';
import LoginForm from '../../LoginForm/LoginForm';
import { AuthContext } from '../../../context/AuthContext';
import './FrontPageNavBar.css';
import Avatar from '../../Avatar/FrontWeb/Avatar';

const FrontPageNavBar = () => {
  const [loginFormVisible, setLoginFormVisible] = useState(false);
  const { isAuthenticated } = useContext(AuthContext);

  function togglePop() {
    setLoginFormVisible(!loginFormVisible);
    console.log(loginFormVisible);
  }

  return (
    <div className='front-page-nav-bar'>
      <div className='nav-bar-contain'>
        <div className='nav-bar-left'>
          <div className='nav-bar-logo'>
            <a href='/' className='nav-bar-logo-a'>
              <img src={logo} alt='logo' />
            </a>
          </div>
        </div>
        <div className='nav-bar-middle'>
          <div className='nav-bar-menu'>
            <ul>
              <li><a className='active' href="/">Trang chủ</a></li>
              <li><a href="/menu">Thực đơn</a></li>
              <li><a href="/contact">Liên hệ</a></li>
            </ul>
          </div>
        </div>
        <div className='nav-bar-right'>
          <div className='nav-bar-authentication'>
            <div className='nav-bar-authentication-contain'>
              {isAuthenticated ? (
                <div className='nav-bar-authentication-avatar'>
                  <Avatar />
                </div>
              ) : (
                <button 
                  className='nav-bar-authentication-button'
                  onClick={togglePop}
                >Đăng nhập</button>
              )}
              {loginFormVisible && <LoginForm togglePop={togglePop} />}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default FrontPageNavBar;
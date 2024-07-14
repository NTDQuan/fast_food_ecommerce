import React from 'react';
import FrontPageNavBar from '../../Components/NavBar/FrontPage/FrontPageNavBar';
import { Outlet } from 'react-router-dom';
import './FrontWebLayout.css';

const FrontWebLayout = () => {
  return (
    <div className='front-web-layout'>
      <div className='front-web-header'>
        <FrontPageNavBar />
      </div>
      <div className='front-web-body'>
        <Outlet />
      </div>
      <div className='front-web-footer'>
        {/* Footer content can be added here */}
      </div>
    </div>
  );
}

export default FrontWebLayout;
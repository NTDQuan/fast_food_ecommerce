import React, { useContext } from 'react'
import { ReactComponent as UserIcon } from '../../../Asserts/user_icon.svg'
import { useNavigate } from "react-router-dom";
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import { AuthContext } from '../../../context/AuthContext';

import './Avatar.css'
import { logout } from '../../../Service/AuthenticationService';

const Avatar = () => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const { logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  }

  const handleLogout = (event) => {
    event.preventDefault();
    logout();
    navigate('/');
    handleClose();
  }

  return (
    <div className='avatar'>
        <div className='avatar-wrapper'>
            <UserIcon onClick={handleClick}/>
            <Menu
              id="user-menu"
              anchorEl={anchorEl}
              open={open}
              onClose={handleClose}
              MenuListProps={{
                'aria-labelledby': 'user-menu',
              }}
            >
              <MenuItem onClick={handleClose}>Tài khoản</MenuItem>
              <MenuItem onClick={handleLogout}>Đăng xuất</MenuItem>
            </Menu>
        </div>
    </div>
  )
}

export default Avatar

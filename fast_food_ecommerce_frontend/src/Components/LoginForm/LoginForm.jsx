import React, { useState, useContext } from 'react'
import { useNavigate } from "react-router-dom";
import logo from '../../Asserts/KFC.png'
import './LoginForm.css'

import { authentication } from '../../Service/AuthenticationService'
import { AuthContext } from '../../context/AuthContext'

const LoginForm = (props) => {
    const [input, setInput] = useState({});
    const [error, setError] = useState('');
    const { login } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInput(values => ({...values, [name]: value}))
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const result = await authentication(input);
            if(result) {
                login(result.accessToken);
                navigate('/');
                props.togglePop();
            }
            setError('');
        } catch (error) {
            console.error('Login failed:', error)
            setError("Sai thông tin đăng nhập")
        }
    }

    return (
        <div className='login-form'>
            <div className='login-form-content'>
                <div>
                    <p className='fas fa-times' onClick={props.togglePop}>X</p>
                </div>
                <div className='logo-header'>
                    <a className='logo' href='/'>
                        <img src={logo} alt='logo' />
                    </a>
                </div>
                <div className='title-block'>
                    <span>vui lòng đăng nhập</span>
                </div>
                <div className='login-form-input'>
                    <form onSubmit={handleSubmit}>
                        <div className='login-form-input-field'>
                            <fieldset>
                                <input name='username' type='text' placeholder='Tài khoản' onChange={handleChange} required/>
                                <input name='password' type='password' placeholder='Mật khẩu' onChange={handleChange} required/>
                                {error && <div className='error-message'><p className='error-message'>{error}</p></div>}
                                <div className='login-form-input-submit'>
                                    <button className='login-form-input-submit-button'>Đăng nhập</button>
                                </div>
                            </fieldset>
                        </div>
                        <div className='login-form-input-register'>
                            <p>Bạn chưa có tài khoản?  <a href="/register">Đăng ký ngay</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default LoginForm

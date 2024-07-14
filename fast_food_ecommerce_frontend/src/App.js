import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import MainPage from './Pages/MainPage/MainPage';
import FrontWebLayout from './Pages/FrontWebLayout/FrontWebLayout';
import { AuthProvider } from './context/AuthContext';

function App() {
  return (
    <div className="App">
      <AuthProvider>
        <div className="page-wrapper">
          <Routes>
            <Route path='/' element={<FrontWebLayout />}>
              <Route index element={<MainPage />} />
            </Route>
          </Routes>
        </div>
      </AuthProvider>
    </div>
  );
}

export default App;
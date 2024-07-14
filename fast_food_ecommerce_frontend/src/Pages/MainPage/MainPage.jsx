import React from 'react';
import './MainPage.css';
import ImageSlider from '../../Components/ImageSlider/ImageSlider';
import { SliderData } from '../../Components/ImageSlider/SliderData';

const MainPage = () => {
  return (
    <div className='main-page'>
      <ImageSlider slides={SliderData} />
    </div>
  );
}

export default MainPage;
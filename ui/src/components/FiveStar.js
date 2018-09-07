import React from 'react';
import Ratings from 'react-ratings-declarative';

const FiveStar = ({ value, color }) => {
  return (
    <Ratings
      rating={parseFloat(value)}
      widgetDimensions="50px"
      widgetSpacings="15px"
    >
      <Ratings.Widget widgetRatedColor={color} />
      <Ratings.Widget widgetRatedColor={color} />
      <Ratings.Widget widgetRatedColor={color} />
      <Ratings.Widget widgetRatedColor={color} />
      <Ratings.Widget widgetRatedColor={color} />
    </Ratings>
  );
};

export default FiveStar;

import React, { Component } from 'react';
import FiveStar from './FiveStar';

class PortfolioRating extends Component {
  render() {
    let { value, trend, color } = this.props;
    value = value.toFixed(2);
    return (
      <div className="portfolio-rating" style={{ color }}>
        <h2>Your personal sustainability index score</h2>
        <div className="rating-value">{value}</div>
        <div className={trend > 0 ? 'rating-trend-up' : 'rating-trend-down'} />
        <FiveStar value={value} color={color} />
      </div>
    );
  }
}

export default PortfolioRating;

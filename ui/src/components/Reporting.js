import React, { Component } from 'react';
import PortfolioRating from './PortfolioRating';
import Portfolio from './Portfolio';

class Reporting extends Component {
  calculate() {
    const { ranking } = this.props;
    if (ranking < 3) return '#990000';
    if (ranking < 5) {
      return '#885511';
    }
    if (ranking < 6) return '#AA8811';
    if (ranking < 8) {
      return '#88BB11';
    }
    return '#11AA11';
  }

  render() {
    const { ranking, investments, onProductRemove } = this.props;
    const color = this.calculate();
    return (
      <div className="reporting">
        <PortfolioRating value={ranking} color={color} trend="-1" />
        <Portfolio investments={investments} onRemove={onProductRemove} />
      </div>
    );
  }
}

export default Reporting;

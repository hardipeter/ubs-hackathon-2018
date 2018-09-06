import React, { Component } from 'react';
import { callFetch } from '../services/repository';
import FiveStar from './FiveStar';

class PortfolioRating extends Component {
  
  state = {
      value : 7,
      trend : 1,
  }
  
  componentDidMount() {
  }
  
  calculate() {
      if (this.state.value <3)
        return "#990000";
      if (this.state.value < 5) {
          return "#885511";
      }
      if (this.state.value <6)
        return "#AA8811";
      if (this.state.value < 8) {
          return "#88BB11";
      }
      return "#11AA11";
  }

  render() {
    const {value, trend} = this.state;
    var backgroundColor = this.calculate();
    return (
        <div className="portfolioRating">
            <div />
            <div>
              <table className="rating-table" bgcolor={backgroundColor}>
                <tbody>
                <tr>
                  <td>
                    <div className="rating-value">{value}</div>
                  </td>
                  <td>
                    <div className="rating-trend-up"/>
                  </td>
                </tr>
                <tr>
                  <td colSpan="2"><FiveStar value={value}/></td>
                </tr>
        </tbody>
              </table>
            </div>
        </div>
    );
  }
}

export default PortfolioRating;

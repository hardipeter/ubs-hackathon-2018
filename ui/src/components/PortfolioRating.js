import React, { Component } from 'react';
import { callFetch } from '../services/repository';
import FiveStar from './FiveStar';

class PortfolioRating extends Component {
  
  state = {
      value : 5,
      trend : 1,
  }
  
  componentDidMount() {
  }
  
  calculate() {
      return "#900000";
  }

  render() {
    const {value, trend} = this.state;
    var backgroundColor = this.calculate();
    return (
        <div className="settings-container">
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

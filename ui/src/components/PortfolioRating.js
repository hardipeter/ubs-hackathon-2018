import React, { Component } from 'react';
import { callFetch } from '../services/repository';
import FiveStar from './FiveStar';

class PortfolioRating extends Component {
  
  componentDidMount() {
  }
  
  calculate() {
      if (this.props.value <3)
        return "#990000";
      if (this.props.value < 5) {
          return "#885511";
      }
      if (this.props.value <6)
        return "#AA8811";
      if (this.props.value < 8) {
          return "#88BB11";
      }
      return "#11AA11";
  }

  render() {
    const {value, trend} = this.props;
    var backgroundColor = this.calculate();
    return (
        <div>
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

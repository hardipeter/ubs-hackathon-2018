import React, { Component } from 'react';
import FiveStar from './FiveStar';

class PortfolioRating extends Component {
  
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
    let {value, trend} = this.props;
    value = value.toFixed(2);
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
                    <div className={trend > 0 ? "rating-trend-up" : "rating-trend-down"}/>
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

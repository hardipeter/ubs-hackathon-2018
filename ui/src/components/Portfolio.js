import React, { Component } from 'react';
import { callFetch } from '../services/repository';

class Portfolio extends Component {
  render() {
    const { investments } = this.props;

    return (
      <div className="portfolio-container">
        <div className="portfolio-header">Client portfolio</div>
        <table className="portfolio-content">
          <tr>
            <th>Investment</th>
            <th>Ranking</th>
            <th>Weigth</th>
            <th>Action</th>
          </tr>
          {investments.map((investment, index) => {
            return (
              <tr>
                <td>{investment.name}</td>
                <td>{investment.ranking.toFixed(2)}</td>
                <td>{investment.portfolioWeight.toFixed(2)}</td>
                <td>
                  <button onClick={this.removeInvestment(index)}>X</button>
                </td>
              </tr>
            );
          })}
        </table>
      </div>
    );
  }
  removeInvestment = id => () => {
    this.props.onRemove(id);
  };
}

export default Portfolio;

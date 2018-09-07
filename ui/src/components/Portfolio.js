import React, { Component } from 'react';

class Portfolio extends Component {
  
  render() {
    const { investments } = this.props;

    return (
      <div className="portfolio-container">
        <div className="portfolio-header">Client portfolio</div>
        <table className="portfolio-content">
        <tr>
        <th>Investment</th><th>Ranking</th><th>Weigth</th>
        </tr>
        {investments.map(investment => {
          return (
            <tr>
                <td>{investment.name}</td>
                <td>{investment.ranking.toFixed(2)}</td>
                <td>{investment.portfolioWeight.toFixed(2)}</td>
            </tr>
          );
        })}
    </table>
      </div>
    );
  }
}

export default Portfolio;

import React, { Component } from 'react';

class Portfolio extends Component {
  render() {
    const { investments } = this.props;

    return (
      <div className="portfolio-container">
        <div className="portfolio-header">UBS Advice SI Portfolio</div>
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
                <td>{(investment.portfolioWeight * 100).toFixed(2)} %</td>
                <td>
                  <a
                    className="remove-button"
                    onClick={this.removeInvestment(index)}
                    title="Remove"
                  >
                    <svg
                      viewPort="0 0 12 12"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <line
                        x1="1"
                        y1="14"
                        x2="14"
                        y2="1"
                        stroke="red"
                        stroke-width="2"
                      />
                      <line
                        x1="1"
                        y1="1"
                        x2="14"
                        y2="14"
                        stroke="red"
                        stroke-width="2"
                      />
                    </svg>
                  </a>
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

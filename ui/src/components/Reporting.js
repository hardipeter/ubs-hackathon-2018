import React, { Component } from 'react';
import PortfolioRating from './PortfolioRating';

class Reporting extends Component {
    render() {
        return <div className="portfolioRating">
            <PortfolioRating value={this.props.ranking} trend="-1"/>
            </div>;
    }
}
    
export default Reporting;

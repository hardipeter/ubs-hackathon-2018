import React, { Component } from 'react';
import PortfolioRating from './PortfolioRating';

class Reporting extends Component {
    render() {
        return <div className="portfolioRating">
            <PortfolioRating value="8" trend="1"/>
            </div>;
    }
}
    
export default Reporting;

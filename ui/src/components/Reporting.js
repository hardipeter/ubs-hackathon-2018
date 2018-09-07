import React, { Component } from 'react';
import PortfolioRating from './PortfolioRating';
import Portfolio from './Portfolio';

class Reporting extends Component {
    render() {
        return <div className="portfolioRating">
            <PortfolioRating value={this.props.ranking} trend="-1"/>
            <Portfolio investments={this.props.investments}/>
            </div>;
    }
}
    
export default Reporting;

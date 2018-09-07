import React from 'react';

const FiveStar = ({ value }) => {
    let starNodes = [];
    while (value >= 2) {
        const starNode = (
           <img className="fullStar"/>
        )
        starNodes.push(starNode);
        value -=2;
    }
    
    if (value > 0.5) {
        const starNode = (
           <img className="halfStar"/>
        );
        starNodes.push(starNode);
    }
    
    while (starNodes.length < 5) {
        const starNode = (
           <img className="emptyStar"/>
        );
        starNodes.push(starNode);
    }
    
    return starNodes;
};

export default FiveStar;

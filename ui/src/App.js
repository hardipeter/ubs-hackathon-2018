import React, { Component } from 'react';
import './App.css';
import Preferences from './components/Preferences';

class App extends Component {
  state = {
    data: null,
  };

  componentDidMount() {
    fetch('http://localhost:3001/preferences', { mode: 'cors' })
      .then(response => response.json())
      .then(data => {
        this.setState({ data });
      });
  }

  render() {
    const { data } = this.state;

    if (!data) {
      return <div className="spinner" />;
    }

    const { preferenceCategories } = data;
    return <Preferences categories={preferenceCategories} />;
  }
}

export default App;

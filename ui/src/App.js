import React, { Component } from 'react';
import './styles/App.css';
import Preferences from './components/Preferences';
import Reporting from './components/Reporting';
import { callFetch } from './services/repository';
import Menu from './components/Menu';
import TopBar from './components/TopBar';

const getRandomColorCode = () => {
  return Math.floor(Math.random() * 1000000);
};

class App extends Component {
  state = {
    data: null,
    color: getRandomColorCode(),
  };

  componentDidMount() {
    callFetch('preferences')
      .then(response => response.json())
      .then(data => {
        this.setState({ data });
      });
  }

  handlePreferencesChange = () => {
    callFetch('investments')
    .then(response => response.json())
    .then(data => {
        this.setState({ color: getRandomColorCode() });
    });
  };

  renderContent() {
    const { data, color } = this.state;
    if (!data) {
      return <div className="spinner" />;
    }

    const { categories } = data;
    return (
      <div className="grid-wrapper">
        <header>
          <div className="top">
            <div className="logo">
              <a title="UBS Switzerland" href="/" />
            </div>
            <div className="top-bar-wrapper">
              <TopBar />
            </div>
          </div>
          <Menu />
        </header>
        <div className="content-container">
          <Preferences
            categories={categories}
            onChange={this.handlePreferencesChange}
          />
          <Reporting/>
        </div>
        <footer>
          <div class="footer-disclaimer">
            The products, services, information and/or materials contained
            within these web pages may not be available for residents of certain
            jurisdictions. Please consult the sales restrictions relating to the
            products or services in question for further information.
            <br />© UBS 1998-2018. All rights reserved.
          </div>
        </footer>
      </div>
    );
  }

  render() {
    return <div className="container">{this.renderContent()}</div>;
  }
}

export default App;

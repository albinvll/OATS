import React, { Component } from 'react';
import { Route } from 'react-router';
import { Home } from './components/home/Home'

import './custom.css'
import { Register } from './components/register/Register';
import { Summarization } from './components/summarization/Summarization';

export default class App extends Component {
  static displayName = App.name;

  render () {
    return (
      <>
        <Route exact path='/' component={Home} />
        <Route exact path='/register' component={Register} />
        <Route exact path='/summarization' component={Summarization} />
      </>
    );
  }
}

import React, { Component } from 'react';
import { Route } from 'react-router';
import { Home } from './components/home/Home'
import requireAuth from './components/ProtectedRoute';

import './custom.css'
import { Register } from './components/register/Register';
import { Summarization } from './components/summarization/Summarization';
import LogoutPage from './components/LogoutPage';
import { ViewText } from './components/summarization/ViewText';

export default class App extends Component {
  static displayName = App.name;

  render () {
    return (
      <>
        <Route exact path='/login' component={Home} />
        <Route exact path='/register' component={Register} />
        <Route exact path='/' component={requireAuth(Summarization)} />
        <Route exact path='/logout' component={LogoutPage}/>
        <Route exact path='/viewText' component={requireAuth(ViewText)}/>
      </>
    );
  }
}

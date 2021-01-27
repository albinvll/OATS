import React, { Component } from 'react';
import { MDBCard, MDBCardBody, MDBInput, MDBIcon, MDBBtn } from 'mdbreact';
import './home.css';
import axios from 'axios';

export class Home extends Component {
	static displayName = Home.name;

	state = {
		email:"",
		password:""
	}

	loginForm(){
		return(
			<>
			<div id={"login-card-div"}>
				<div>
					<h1>OATS</h1>					
				</div>
				<MDBCard className={"login-card"}>
					<MDBCardBody>
						<MDBInput value={this.state.email} label="E-mail" icon="envelope" onChange={this.handleEmailChange}/>
						<MDBInput value={this.state.password} type="password" label="Password" icon="lock" onChange={this.handlePasswordChange}/>
						<div  className="text-center">
							<button onClick={(e)=>this.attempLogin(e)} id="login-button">Login</button>
						</div>
					</MDBCardBody>
				</MDBCard>
			</div>
			</>
		);
	}
	attempLogin=async(event)=> {
		event.preventDefault();
        console.log("test test");
        const response = await axios.post("http://localhost:8080/api/login/",
            {
				id: null,
                emri: null,
                mbiemri: null,
                email: this.state.email,
                password: this.state.password,
                idSubscription: null
            }
        );
        console.log(response.data)
	}

	handleEmailChange=(event)=>{
		this.setState({email: event.target.value});
	}

	handlePasswordChange=(event)=>{
		this.setState({password: event.target.value});
	}

	render () {
	    return (
				<>
					{this.loginForm()}
				</>
		);
	}
}

import React, { Component } from 'react';
import { MDBCard, MDBCardBody, MDBInput, MDBIcon, MDBBtn } from 'mdbreact';
import './home.css';
import axios from 'axios';
import * as auth from '../../Auth';
import { ToastsContainer, ToastsContainerPosition, ToastsStore } from 'react-toasts';


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
							<button onClick={(e)=>this.goToRegistration(e)} id="login-button">Register</button>
						</div>
					</MDBCardBody>
				</MDBCard>
			</div>
			</>
		);
	}

	goToRegistration =(event)=>{
		event.preventDefault();
		this.props.history.push("/register");
	}

	attempLogin=async(event)=> {
		event.preventDefault();
		if(!this.state.email || this.state.email?.length <= 0){
			ToastsStore.error("Please type your email");
			return;
		}
		if(!this.state.password || this.state.password?.length <= 0){
			ToastsStore.error("Please type your password");
			return;
		}
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
		if(response && response.data){
			auth.saveUser(response.data.id);
			this.props.history.push("/");
		}else{
			ToastsStore.error("This user does not exist");
			return;
		}
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
					<ToastsContainer store={ToastsStore} position={ToastsContainerPosition.TOP_RIGHT} />
					{this.loginForm()}
				</>
		);
	}
}

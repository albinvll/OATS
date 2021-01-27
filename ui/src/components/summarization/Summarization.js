import React, { Component } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody, MDBInput, MDBCard, MDBCardBody,MDBIcon } from 'mdbreact';
import "./summarization.css";
import client from '../../axios';
import { ToastsContainer, ToastsContainerPosition, ToastsStore } from 'react-toasts';
import { USERID } from '../../Auth';

export class Summarization extends Component {
    static displayName = Summarization.name;
    state={
        summarizations:[
            {
                id:1,
                summarizedText:"Lorem ipsum dolor...",
                dataERegjistrimit:"01/01/2000",
                summPercentage:"",
                text:""
            }
        ]
    }

    componentDidMount(){
        this.fillSummarizationTable();
    }

    fillSummarizationTable = async() =>{
        const response = await client.post("http://localhost:8080/api/summarization/getTable/" + localStorage.getItem(USERID));
        if(response){
            if(response.data){
                this.setState({summarizations:response.data});
            }
        }
    }
    

    showSummarizationsList(){
        return(
            <MDBCard className="summarization-div-item">
                <MDBCardBody>
                    <MDBTable>
                        <MDBTableHead>
                            <tr>
                                <th>ID</th>
                                <th>Content</th>
                                <th>Finished date</th>
                                <th>View content</th>
                            </tr>
                        </MDBTableHead>
                        <MDBTableBody>
                            {
                                this.state.summarizations.length > 0 ? (this.state.summarizations.map((element,key) =>{
                                    return (<tr key={key}>
                                        <td>{element.id}</td>
                                        <td>{this.cutSummarized(element.summarizedText)}</td>
                                        <td>{element.dataERegjistrimit}</td>
                                        <td><button className="summarizationButton"onClick={(e)=>this.viewText(e,element.summarizedText)}>View</button></td>
                                    </tr>)
                                })):<></>
                            }
                        </MDBTableBody>
                    </MDBTable>
                </MDBCardBody>
            </MDBCard>
        )
    }

    viewText=(e,summarizedText)=>{
        this.props.history.push({
                pathname: "/viewText",
                state: { text: summarizedText}
            });
    }

    cutSummarized(text){
        let splitText = text.split(" ");
        if(splitText.length >3){
            return(splitText[0] + " " + splitText[1] + " " + splitText[3] + "...");
        }else{
            return text + "...";
        }
    }   
    
    showSummariztionInput(){
        return(
            <>
            <MDBCard className="summarization-div-item">
                <MDBCardBody>
                    <h1>
                        Place file to summarize
                    </h1>
                    <textarea onChange={this.handleTextArea} value={this.state.text} />
                    <MDBInput value={this.state.summPercentage} onChange={this.handleSummPercentageInput} type="text" label="Summarization percentage..."/>
                    <p>Input type: txt</p>
                    <p>Output type: txt</p>
                    <button className="summarizationButton" onClick={(e) => this.attempSummarization(e)}>Summarize</button>
                </MDBCardBody>
            </MDBCard>
            </>
        )
    }

    handleTextArea = event=>{
        this.setState({text:event.target.value});
    }

    attempSummarization=async(event)=>{
        event.preventDefault();
        if(!this.state.text || this.state.text?.length <= 0){
            ToastsStore.error("Please type some text you need to summarize");
            return;
        }
        if(!this.state.summPercentage || this.state.summPercentage?.length <=0){
            ToastsStore.error("Please type the summarization percentage");
            return;
        }
        let summarizeRequest = {
            idPerdoruesi: localStorage.getItem("userId"),
            idLlojiTekstitInput:1,
            getIdLlojiTekstitOutput:1,
            textToSummarize:this.state.text,
            summPercentage:this.state.summPercentage,
            feedback:null
        }
        const response = await client.post("http://localhost:8080/api/summarization/summarizeText",summarizeRequest);
        if(response){
            console.log(response);
            this.fillSummarizationTable();
        }
    }

    handleSummPercentageInput= event=>{
        if(!isNaN(event.target.value)){
            this.setState({summPercentage: event.target.value})
            console.log(event.target.value)
        }
    }

    render(){
        return(
            <>
                <div id="summarization-div">
                    <a id="logoutButton" href="/logout"><MDBIcon icon="power-off" /></a>
                    <ToastsContainer store={ToastsStore} position={ToastsContainerPosition.TOP_RIGHT} />
                    {this.showSummariztionInput()}
                    {this.showSummarizationsList()}
                </div>
            </>
        );
    }
}
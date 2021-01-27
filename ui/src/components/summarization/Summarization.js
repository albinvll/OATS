import React, { Component } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody, MDBInput, MDBCard, MDBCardBody } from 'mdbreact';
import "./summarization.css";

export class Summarization extends Component {
    static displayName = Summarization.name;
    state={
        summarizations:[
            {
                id:1,
                firstThreeWords:"Lorem ipsum dolor...",
                dataERegjistrimit:"01/01/2000"
            }
        ]
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
                                        <td>{element.firstThreeWords}</td>
                                        <td>{element.dataERegjistrimit}</td>
                                        <td><button>View</button></td>
                                    </tr>)
                                })):<></>
                            }
                        </MDBTableBody>
                    </MDBTable>
                </MDBCardBody>
            </MDBCard>
        )
    }   
    
    showSummariztionInput(){
        return(
            <>
            <MDBCard className="summarization-div-item">
                <MDBCardBody>
                    <h1>
                        Place file to summarize
                    </h1>
                    <input accept=".txt" onChange={(e) => this.handleFileInput(e.target.files[0])} type="file"/>
                    <MDBInput type="text" label="Summarization percentage..."/>
                </MDBCardBody>
            </MDBCard>
            </>
        )
    }
    handleFileInput = (file) =>{
        var splitFileNameArray = file.name.split(".");
        var fileExtension = splitFileNameArray[splitFileNameArray.length-1]
        if(fileExtension == "txt"){
            console.log("Error")
            return;
        }
    }
    

    render(){
        return(
            <>
                <div id="summarization-div">
                    {this.showSummariztionInput()}
                    {this.showSummarizationsList()}
                </div>
            </>
        );
    }
}
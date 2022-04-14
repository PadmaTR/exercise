import React from "react";
import { createRoot } from 'react-dom/client';

const rootElement = document.getElementById("root");

const DogImageGallery = () => { 

	const fetchApi = () => {
		fetch('https://random.dog/woof.json')
    .then((response) =>{
      return response.json();
    })
	}
	 let images = [
		 {src:{fetchApi} , title:"dog1"},
		 {src:{fetchApi} , title:"dog2"},
		 {src:{fetchApi} , title:"dog3"},
		 {src:{fetchApi} , title:"dog4"},
		 {src:{fetchApi} , title:"dog5"},
		 {src:{fetchApi} , title:"dog6"}
	 ];
		return(
			<>
			<center>
				<h1>Dogs Image Gallery</h1>
				<hr/>
				<div key ={fetchApi}>{
					images.map((index)=>
					<img src={index.src.url} title = {index.title} 
						height="500" width="500" />)
				}
				</div>
			</center>
			</>
		
		)
}


const container = document.getElementById('root');
const root = createRoot(container); 
root.render(<DogImageGallery tab="home" />);

export default DogImageGallery;

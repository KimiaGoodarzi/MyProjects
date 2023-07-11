import {useState} from 'react';
import Modal from './Modal.js'; 
import Backdrop from'./Backdrop.js';

function Todos(props){
    const[modalIsOpen, setModalIsOpen]=useState(false);   

    function deleteHandler(){
       setModalIsOpen(true);
    }

    function closeModalHandler(){
        setModalIsOpen(false);
    }

    console.log(modalIsOpen)
return(
<div className ='card'>
    <h1>Title</h1>
    <h2>{props.text}</h2>
    <div className= 'actions'>
        
        <button className= 'btn' onClick={deleteHandler}>Delete</button>
    </div>
    {modalIsOpen && <Modal onCancel={closeModalHandler} onConfirm={closeModalHandler}/>} 
    {modalIsOpen && <Backdrop gay={closeModalHandler} />}
</div>


);
}
export default Todos; 
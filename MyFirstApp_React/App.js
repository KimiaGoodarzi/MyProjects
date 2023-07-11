
import Todos from './components/Todos'; 

function App() {
  return(
    <div>
      <h1>My Todo List</h1>
      <Todos text= 'learn react'/>
      <Todos text= 'master react' />
      <Todos text= 'go through the cours' />
   
    </div>
  );
}

export default App;

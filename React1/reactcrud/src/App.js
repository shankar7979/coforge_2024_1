import logo from './logo.svg';
import './App.css';
import PersonForm from './PersonForm';
import {PersonForm1} from './PersonForm1';
import { PersonGetAll } from './PersonGetAll';

function App() {
  return (
    <div className="App">
     {/* <PersonForm>      
     </PersonForm> */}
     {/* <PersonForm1></PersonForm1> */}
     <PersonGetAll></PersonGetAll>
    </div>
  );
}

export default App;

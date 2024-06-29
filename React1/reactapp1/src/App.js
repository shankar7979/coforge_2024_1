import logo from './logo.svg';
import './App.css';
import Hello from './Hello';
import Customer from './Customer';
import Counter from './Counter';
import { address } from './Address';
import { country } from './Country';

function App() {
  return (
    <div className="App">
      {/* <Hello></Hello> */}
      <Customer country="India"></Customer>
      <Customer country1={country}></Customer>
      <Counter address={address}></Counter>
    </div>
  );
}

export default App;

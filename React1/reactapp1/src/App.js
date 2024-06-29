import logo from './logo.svg';
import './App.css';
import Hello from './Hello';
import Customer from './Customer';
import Counter from './Counter';
import { address } from './Address';
import { Country } from './Country';

function App() {
  return (
    <div className="App">
      {/* <Hello></Hello> */}
      <Customer country="India"></Customer>
      <Customer country1={Country}></Customer>
      <Counter address={address}></Counter>
    </div>
  );
}

export default App;

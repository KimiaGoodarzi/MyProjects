import React, { useState, useEffect } from 'react';

const App = () => {
  const [ethPrice, setEthPrice] = useState(0);

  useEffect(() => {
    const fetchEthPrice = async () => {
      try {
        const response = await fetch('https://api.exchange.com/v1/eth_price');
        const data = await response.json();
        setEthPrice(data.eth_price);
      } catch (error) {
        console.error(error);
      }
    };

    fetchEthPrice();
  }, []);

  return (
    <div>
      <h1>Ethereum Price</h1>
      <p>{ethPrice}</p>
    </div>
  );
};

export default App;

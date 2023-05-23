import React, { useState } from 'react';
import './BathroomAmountInput.css';

function BathroomAmountInput({ onAmountSubmit }) {
    const [bathroomAmount, setBathroomAmount] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAmountSubmit(bathroomAmount);
    };

    return (
        <div className="bathroom-amount-input">
            <h2>배변량 입력</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={bathroomAmount}
                    onChange={(e) => setBathroomAmount(e.target.value)}
                    required
                />
                <button type="submit">입력</button>
            </form>
        </div>
    );
}

export default BathroomAmountInput;

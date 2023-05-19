import React, { useState } from 'react';

function FoodAmountInput({ onAmountSubmit }) {
    const [foodAmount, setFoodAmount] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAmountSubmit(foodAmount);
    };

    return (
        <div>
            <h2>산책 입력</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={foodAmount}
                    onChange={(e) => setFoodAmount(e.target.value)}
                    required
                />
                <button type="submit">입력</button>
            </form>
        </div>
    );
}

export default FoodAmountInput;

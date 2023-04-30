import React from 'react';

function PetJournalList(props) {
    const entries = props.entries.map((entry) => (
        <li key={entry.date.toString()}>
            Food: {entry.food}, Water: {entry.water}
        </li>
    ));

    return (
        <div>
            <h2>기록</h2>
            <ul>{entries}</ul>
        </div>
    );
}

export default PetJournalList;

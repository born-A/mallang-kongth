import React, { useState } from 'react';
import PetJournalForm from './PetJournalForm';
import PetJournalList from './PetJournalList';

function PetJournal() {
    const [journalEntries, setJournalEntries] = useState([]);

    const addJournalEntry = (entry) => {
        setJournalEntries((prevEntries) => [...prevEntries, entry]);
    };

    return (
        <div>
            <PetJournalForm onAddEntry={addJournalEntry} />
            <PetJournalList entries={journalEntries} />
        </div>
    );
}

export default PetJournal;

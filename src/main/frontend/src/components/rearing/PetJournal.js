import React, { useState } from 'react';
import PetJournalForm from './PetJournalForm';
import PetJournalList from '../PetJournalList';
import './PetJournal.css';

function PetJournal() {
    const [journalEntries, setJournalEntries] = useState([]);

    const addJournalEntry = (entry) => {
        setJournalEntries((prevEntries) => {
            const newEntry = {
                ...entry,
                date: new Date(),
            };
            return [...prevEntries, newEntry];
        });
    };

    const editJournalEntry = (index, entry) => {
        setJournalEntries((prevEntries) => {
            const updatedEntries = [...prevEntries];
            updatedEntries[index] = entry;
            return updatedEntries;
        });
    };

    const deleteJournalEntry = (index) => {
        setJournalEntries((prevEntries) => {
            const updatedEntries = [...prevEntries];
            updatedEntries.splice(index, 1);
            return updatedEntries;
        });
    };

    return (
        <div>
            <PetJournalForm onAddEntry={addJournalEntry} />
            <PetJournalList
                entries={journalEntries}
                onEditEntry={editJournalEntry}
                onDeleteEntry={deleteJournalEntry}
            />
        </div>
    );
}

export default PetJournal;

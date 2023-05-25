import React, {useState} from "react";
import "../../css/petRegister.css";
import {Link} from 'react-router-dom';


export default function PetRegister() {

    const [gender, setGender] = useState('male');
    const [pet, setPet] = useState('dog');
    const [name, setName] = useState("");
    const [birth, setBirth] = useState("");
    const [neut, setNeut] = useState('yes');
    const [attachedFile, setAttachedFile] = useState(null);

    const handleGenderChange = (event) => {
        setGender(event.target.value);
    };

    const handlePetChange = (event) => {
        setPet(event.target.value);
    };

    const handleNameChange = (event) => {
        setName(event.target.value);
    };

    const handleBirthChange = (event) => {
        setBirth(event.target.value);
    };

    const handleNeutChange = (event) => {
        setNeut(event.target.value);
    };

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        setAttachedFile(file);
    };

    const handleConfirm = (e) => {
        if (name == "") {
            e.preventDefault();
            alert("반려동물의 이름을 입력해주세요 !");
        }
        else {
            const isConfirmed = window.confirm(`반려동물 정보를 저장하시겠습니까?`);
            if (isConfirmed) {
                //window.location.href = '/mainPage';

            } else {
                //
            }
        }
    };


    return (
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                    <Link to ="/mainPage"><span className="home">home</span></Link>
                </div>

                {/* 반려동물 정보 입력 페이지 */}
                <div className="pageName">
                    <span>반려동물 정보 입력</span>
                </div>
                {/* 뒤로가기 및 작성완료료 */}
                <div className="boardHead">
                    <Link to ="/mainPage"><span className="linkback"> &lt; 뒤로가기 </span></Link>
                </div>


                {/* 이미지 등록 */}

                    <div className="image">
                    <div className="smallBox">
                        {attachedFile ? (
                            <img
                                src={URL.createObjectURL(attachedFile)}
                                alt="Uploaded File"
                                style={{ maxWidth: '100px', maxHeight: '100px' }}
                            />
                        ) : (
                            <div
                                style={{
                                    width: '100px',
                                    height: '100px',
                                    backgroundColor: '#eaeaea',
                                }}
                            ></div>
                        )}
                    </div>

                    <input type="file" className="file-button" onChange={handleFileChange} />

                </div>

                {/* 정보 입력 */}
                <div className="information">
                    <p>반려동물 <label><input type="radio" value="dog" checked={pet === 'dog'} onChange={handlePetChange}/> 강아지 </label>
                        <label><input type="radio" value='cat' checked={pet === 'cat'} onChange={handlePetChange}/> 고양이 </label></p>

                    <p>이름 <input type="text" maxLength={6} className="petname" placeholder="여섯 글자까지 가능" value={name} onChange={handleNameChange} /></p>

                    <p>생년월일 <input type="date" value={birth} onChange={handleBirthChange} placeholder="ex) 23-05-18 식으로 입력"/> </p>
                    <p>몸무게 <input type="number" />kg </p>
                    <p>성별 <label><input type="radio" value="male" checked={gender === 'male'} onChange={handleGenderChange}/> 남아 </label>
                        <label><input type="radio" value="female" checked={gender === 'female'} onChange={handleGenderChange}/> 여아 </label> </p>
                    <p>중성화 <label><input type="radio" value="yes" checked={neut === 'yes'} onChange={handleNeutChange}/> 했어요 </label>
                        <label><input type="radio" value="no" checked={neut === 'no'} onChange={handleNeutChange}/> 안했어요 </label></p>
                </div>
                <div className="confirm-button">
                    <Link to={"/mainPage"}><button className="confirm" onClick={handleConfirm} >완 료 하 기</button></Link>
                </div>



            </div>
        </div>
    );
}
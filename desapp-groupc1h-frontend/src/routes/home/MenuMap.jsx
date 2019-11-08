import React, {useState} from 'react';
import {HEREMap, Marker} from "here-maps-react";
import {Button, Icon, Modal} from "antd";

function MenuMap(props) {
    const coords = {lat: -12.0464, lng: -77.0428};
    const [visible, setVisible] = useState(false);

    function showModal() {
        setVisible(true);
    }

    function onClose() {
        setVisible(false);
    }

    return (
        <div>
            <Button type="primary" onClick={showModal}>
                Open Modal
            </Button>
            <Modal
                title={<span>Menu de cumpleaños, Alsina 233, Quilmes  <Icon type="environment" style={{color: "#FF8C00"}}/> </span>}
                visible={visible}
                onCancel={onClose}
                footer={null}
                style={{ top: 20 }}
                bodyStyle={{height: "450px"}}
            >
                <HEREMap
                    appId="B3ZYLI1mKHNO6Qt871t6"
                    appCode="xibhrih8Kcvp0bcijbEBqA"
                    center={coords}
                    zoom={15}
                    interactive={true}
                >
                    <Marker
                        lat={coords.lat}
                        lng={coords.lng}
                        draggable={false}
                        onDragEnd={e => {
                            console.log(e)
                        }}
                    />
                </HEREMap>
            </Modal>
        </div>

    )
}

export default MenuMap;
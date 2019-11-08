import React from 'react';
import {HEREMap, Marker} from "here-maps-react";
import {Icon, Modal} from "antd";

function MenuMap({item, onClose, visible}) {

    const MenuMapLabel = () => {
        return `${item.name}, ${item.serviceLocation.address}, ${item.serviceLocation.city}`;
    };

    return (
        <div>
            <Modal
                title={<span> <MenuMapLabel/> <Icon type="environment" style={{color: "#FF8C00"}}/> </span>}
                visible={visible}
                onCancel={onClose}
                destroyOnClose={true}
                footer={null}
                style={{ top: 20 }}
                bodyStyle={{height: "450px"}}
            >
                <HEREMap
                    appId="B3ZYLI1mKHNO6Qt871t6"
                    appCode="xibhrih8Kcvp0bcijbEBqA"
                    center={{lat: item.serviceLocation.latitude, lng: item.serviceLocation.longitude}}
                    zoom={15}
                    interactive={true}
                >
                    <Marker
                        lat={item.serviceLocation.latitude}
                        lng={item.serviceLocation.longitude}
                        draggable={false}
                    />
                </HEREMap>
            </Modal>
        </div>

    )
}

export default MenuMap;
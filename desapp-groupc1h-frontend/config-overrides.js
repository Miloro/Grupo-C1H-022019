const {override, fixBabelImports, addLessLoader} = require("customize-cra");

module.exports = override(
    fixBabelImports("import", {
        libraryName: "antd",
        libraryDirectory: "es",
        style: true,
    }),
    fixBabelImports('formik-antd', {
        libraryName: 'formik-antd',
        libraryDirectory: 'es',
        style: "css",
    }),
    addLessLoader({
        javascriptEnabled: true,
        modifyVars: {
            '@primary-color': '#FF8C00', // primary color for all components
            '@link-color': '#FF8C00', // link color
            '@success-color': '#52c41a', // success state color
            '@warning-color': '#faad14', // warning state color
            '@error-color': '#f5222d', // error state color
            '@font-size-base': '14px', // major text font size
            '@heading-color': '#273239', // heading text color
            '@text-color': '#273239', // major text color
            '@text-color-secondary ': '#273239', // secondary text color
            '@disabled-color ': 'rgba(0, 0, 0, .25)', // disable state color
            '@border-radius-base': '4px', // major border radius
            '@border-color-base': '#d9d9d9', // major border color
            '@box-shadow-base': '0 2px 8px rgba(0, 0, 0, 0.15)', // major shadow for layers
            '@body-background': '#f5f5f5',
            '@component-background': '#f5f5f5',
            '@layout-body-background': '#f5f5f5',
            '@layout-header-background': '#f5f5f5',
        },
    }),
);